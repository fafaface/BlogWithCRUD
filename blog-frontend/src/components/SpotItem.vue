<template>
  <v-card class="mx-auto">
    <v-container fluid>
      <template v-if="!editing">
        <v-card-title>{{ title || "暂无标题" }}</v-card-title>
        <v-card-subtitle>{{ type || "暂无类型" }}</v-card-subtitle>
        <v-card-text>{{ description || "暂无描述" }}</v-card-text>
        <img
          :src="imgurl"
          height="620"
          width="900"
        >
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
          label="标题"
          placeholder="请输入标题"
        />
        <v-select label="类型" v-model="typeInput" :items="items"> </v-select>
        <v-text-field
          v-model="imgurlInput"
          label="图片链接"
          placeholder="请输入图片链接"
        />
        <v-textarea
          v-model="descriptionInput"
          label="内容"
          placeholder="请输入内容"
          hint="对特色的详细介绍"
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
    type: String,
    title: String,
    description: String,
    imgurl: String,
  },
  data: function () {
    return {
      editing: false,
      submitting: false,
      deleting: false,
      typeInput: "",
      titleInput: "",
      descriptionInput: "",
      imgurlInput: "",
      items: ["美食", "美景", "风土人情"],
    };
  },
  methods: {
    edit: function () {
      this.typeInput = this.type;
      this.titleInput = this.title;
      this.descriptionInput = this.description;
      this.imgurlInput = this.imgurl;

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
          type: this.typeInput,
          title: this.titleInput,
          description: this.descriptionInput,
          imgurl: this.imgurlInput,
        }),
      };
      fetch(`/api/spots/${this.id}`, requestOptions).then(() => {
        this.$emit("spot-changed");
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
      fetch(`/api/spots/${this.id}`, requestOptions).then(() => {
        this.$emit("spot-changed");
        this.deleting = false;
      });
    },
  },
};
</script>

<style scoped>
</style>
