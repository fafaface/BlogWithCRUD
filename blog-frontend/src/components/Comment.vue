<template>
  <v-card class="elevation-2">
    <div v-if="contentReply" class="quote">
      <v-card-text class="text--secondary">{{ contentReply }}</v-card-text>
    </div>
    <v-divider v-if="contentReply"></v-divider>
    <v-card-title> {{ username || "用户名" }} </v-card-title>
    <v-card-subtitle
      >#{{ id || "楼层" }} | 回复于
      {{ commentTime.toLocaleString() || "留言时间" }}</v-card-subtitle
    >
    <v-card-text>
      {{ contentComment || "留言内容" }}
    </v-card-text>
    <v-card-text v-if="replying">
      <v-card outlined>
        <v-card-text>
          <v-textarea label="回复这条留言" v-model="contentInput"></v-textarea>
        </v-card-text>
        <v-card-actions>
          <v-btn :loading="submitting" color="indigo" v-on:click="submit" text>提交</v-btn>
          <v-btn
            text
            color="pink lighten-1"
            :disabled="submitting"
            v-on:click="replying = false"
          >
            取消
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-card-text>

    <v-card-actions>
      <v-btn
        v-if="$store.getters.isSignedIn"
        color="indigo"
        text
        v-on:click="replying = true"
        >回复</v-btn
      >
      <v-btn
        v-if="$store.getters.isAdmin"
        text
        color="pink lighten-1"
        :loading="deleting"
        v-on:click="deleteComment"
      >
        删除
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
export default {
  props: {
    id: Number,
    username: String,
    commentTime: Date,
    contentComment: String,
    contentReply: String,
  },
  data: function () {
    return {
      deleting: false,
      replying: false,
      submitting: false,
      contentInput: "",
    };
  },
  methods: {
    submit: function () {
      const requestOptions = {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${this.$store.state.accessToken}`,
        },
        body: JSON.stringify({
          content: JSON.stringify({
            reply: `回复 ${
              this.username
            } 在 ${this.commentTime.toLocaleString()} 发表的留言：${
              this.contentComment
            }`,
            comment: this.contentInput,
          }),
          username: this.$store.state.username,
          commentTime: new Date(),
        }),
      };

      this.submitting = true;
      fetch(`/api/comments`, requestOptions).then(() => {
        this.$emit("comment-changed");
        this.contentInput = "";
        this.submitting = false;
        this.replying = false;
      });
    },
    deleteComment: function () {
      this.deleting = true;
      this.editing = false;
      const requestOptions = {
        method: "DELETE",
        headers: {
          Authorization: `Bearer ${this.$store.state.accessToken}`,
        },
      };
      fetch(`/api/comments/${this.id}`, requestOptions).then(() => {
        this.$emit("comment-changed");
        this.deleting = false;
      });
    },
  },
};
</script>