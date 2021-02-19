<template>
  <v-card class="elevation-2">
    <v-card-text>
      <v-textarea
        label="留言"
        hint="你对博主有什么想说的呢？"
        placeholder="我想说……"
        v-model="contentInput"
        :disabled="!$store.getters.isSignedIn"
        clearable
        clear-icon="mdi-close-circle"
      ></v-textarea>
    </v-card-text>
    <v-card-actions>
      <v-btn
        color="blue darken-1"
        text
        v-if="$store.getters.isSignedIn"
        :loading="submitting"
        v-on:click="submit"
      >
        提交
      </v-btn>
      <v-btn
        color="blue darken-1"
        text
        v-if="!$store.getters.isSignedIn"
        disabled
      >
        登录以留言
      </v-btn>
    </v-card-actions>
  </v-card>
</template>


<script>
export default {
  data: function () {
    return {
      contentInput: "",
      dialog: false,
      hidden: false,
      submitting: false,
    };
  },
  methods: {
    submit: function () {
      this.dialog = false;
      this.submitting = true;
      const requestOptions = {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${this.$store.state.accessToken}`,
        },
        body: JSON.stringify({
          content: JSON.stringify({ comment: this.contentInput }),
          username: this.$store.state.username,
          commentTime: new Date(),
        }),
      };
      fetch(`/api/comments`, requestOptions).then(() => {
        this.$emit("comment-changed");
        this.submitting = false;
        this.contentInput = "";
      });
    },
  },
};
</script>

<style scoped>
.createButton {
  bottom: 80px;
}
</style>