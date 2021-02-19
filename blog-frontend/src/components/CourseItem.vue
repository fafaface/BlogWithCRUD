<template>
  <v-card class="mx-auto">
    <v-container fluid>
      <template v-if="!editing">
        <v-card-title><strong>{{ name || "暂无课程" }} </strong>:{{ grade || "暂无成绩" }}</v-card-title>
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
          v-model="nameInput"
          label="课程名"
          placeholder="课程名"
        />
        <v-textarea
          v-model="gradeInput"
          label="成绩"
          type="number"
        ></v-textarea>
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
    name: String,
    grade: Number,
  },
  data: function () {
    return {
      editing: false,
      submitting: false,
      deleting: false,
      nameInput: "",
      gradeInput: 0,
    };
  },
  methods: {
    edit: function () {
      this.typeInput = this.type;
      this.nameInput = this.name;
      this.gradeInput = this.grade;
      this.editing = true;
    },

    submit: function () {
      this.submitting = true;
      const requestOptions = {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
          "Authorization": `Bearer ${this.$store.state.accessToken}`,
        },
        body: JSON.stringify({
          id: this.id,
          name: this.nameInput,
          grade: parseFloat(this.gradeInput),
        }),
      };
      fetch(`/api/courses/${this.id}`, requestOptions).then(() => {
        this.$emit("course-changed");
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
          "Authorization": `Bearer ${this.$store.state.accessToken}`,
        }
      };
      fetch(`/api/courses/${this.id}`, requestOptions).then(() => {
        this.$emit("course-changed");
        this.deleting = false;
      });
    },
  },
};
</script>

<style scoped>
</style>
