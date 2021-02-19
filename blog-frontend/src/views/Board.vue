<template>
  <div class="board">
    <div class="boardself">
      <v-timeline  :reverse="reverse" dense width="1080">
        <v-timeline-item color="indigo lighten-3">
          <template v-if="loading" v-slot:icon>
            <v-progress-circular
              indeterminate
              size="20"
              width="3"
              color="white"
            />
          </template>
          <CreateComment @comment-changed="fetchData" />
        </v-timeline-item>
        <v-timeline-item
          :color="colors[comment.id % 5]"
          v-for="comment in comments"
          :key="comment.id"
        >
          <span slot="opposite"></span>
          <Comment
            :username="comment.username"
            :commentTime="new Date(comment.commentTime)"
            :id="comment.id"
            :contentComment="comment.content.comment"
            :contentReply="comment.content.reply"
            @comment-changed="fetchData"
          />
        </v-timeline-item>
      </v-timeline>
    </div>
  </div>
</template>

<script>
import CreateComment from "../components/CreateComment.vue";
import Comment from "../components/Comment.vue";

export default {
  components: {
    CreateComment,
    Comment,
  },
  data: function () {
    return {
      loading: false,
      comments: null,
      colors: [
        "red lighten-3",
        "pink lighten-3",
        "pink lighten-4",
        "teal lighten-1",
        "cyan lighten-3",
      ],
    };
  },

  created: function () {
    this.fetchData();
  },

  watch: {
    $route: "fetchData",
    comments: function () {
      this.timer();
    },
  },

  methods: {
    fetchData: async function () {
      this.error = this.spots = null;
      this.loading = true;

      const resp = await fetch(`/api/comments`);
      let respData = await resp.json();

      respData = respData.sort((a, b) => b.id - a.id);

      for (let comment of respData) {
        comment.content = JSON.parse(comment.content);
      }

      this.comments = respData;

      this.loading = false;
    },

    timer: function () {
      return setTimeout(() => {
        this.fetchData();
      }, 5000);
    },
  },
  destroyed: function () {
    clearTimeout(this.timer);
  },
};
</script>

<style scoped>
.boardself {
  max-width: 960px;
  padding-top: 30px;
  margin: auto;
}
</style>
