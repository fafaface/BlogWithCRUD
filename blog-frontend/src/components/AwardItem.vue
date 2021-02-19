<template>
  <v-card class="mx-auto">
    <v-container fluid>
      <template v-if="!editing">
        <v-card-title>{{ title || "暂无奖项" }}</v-card-title>
        <v-card-text>获奖日期：{{ awardDate || "暂无时间" }}</v-card-text>
        <v-card-actions v-if="$store.getters.isAdmin">
          <v-btn color="indigo" text :disabled="deleting" v-on:click="edit"
            >编辑</v-btn
          >
          <v-btn
            text
            color="pink lighten-1"
            :loading="deleting"
            v-on:click="deleteSpot"
            >删除</v-btn
          >
        </v-card-actions>
      </template>

      <template v-if="editing">
        <v-text-field
          v-model="titleInput"
          label="奖项名称"
          required
        ></v-text-field>

        <v-text-field
          label="获奖日期"
          type="date"
          v-model="awardDateInput"
        ></v-text-field>
        <v-card-actions>
          <v-btn :loading="submitting" v-on:click="submit">确定</v-btn>
          <v-btn v-on:click="cancel">取消</v-btn>
        </v-card-actions>
      </template>
    </v-container>
  </v-card>
</template>

<script>
export default {
  props: {
    id: Number,
    title: String,
    awardDate: Date,
  },
  data: function () {
    return {
      editing: false,
      submitting: false,
      deleting: false,
      titleInput: "",
      awardDateInput: null,
    };
  },
  methods: {
    edit: function () {
      this.titleInput = this.title;
      this.awardDateInput = this.awardDate;
      this.editing = true;
    },

    submit: function () {
      this.submitting = true;
      const requestOptions = {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${this.$store.state.accessToken}`,
        },
        body: JSON.stringify({
          id: this.id,
          title: this.titleInput,
          awardDate: this.awardDateInput,
        }),
      };
      fetch(`/api/awards/${this.id}`, requestOptions).then(() => {
        this.$emit("award-changed");
        this.editing = false;
        this.submitting = false;
      });
    },

    cancel: function () {
      this.editing = false;
    },

    deleteSpot: function () {
      this.deleting = true;
      this.editing = false;
      const requestOptions = {
        method: "DELETE",
        headers: {
          Authorization: `Bearer ${this.$store.state.accessToken}`,
        },
      };
      fetch(`/api/awards/${this.id}`, requestOptions).then(() => {
        this.$emit("award-changed");
        this.deleting = false;
      });
    },
  },
};
</script>

<style scoped>
</style>
