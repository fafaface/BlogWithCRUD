<template>
  <v-card class="mx-auto">
    <v-container fluid>
      <template v-if="!editing">
        <v-card-title>{{ title || "暂无项目名称" }}</v-card-title>
        <v-card-text><strong>{{ role || "暂无角色" }} | {{ institution || "暂无所在机构" }}</strong> | {{  startDate.toLocaleString() || "暂无开始日期" }} ～ {{ endDate || "暂无结束日期" }}</v-card-text>        
        <v-card-text>项目简介: {{ description || "暂无经历描述" }}</v-card-text>

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
          label="项目名称"
          required
        ></v-text-field>
        <v-text-field
          label="所在机构"
          v-model="institutionInput"
        ></v-text-field>
        <v-text-field
          label="开始日期"
          type="date"
          v-model="startDateInput"
        ></v-text-field>
        <v-text-field
          label="结束日期"
          type="date"
          v-model="endDateInput"
        ></v-text-field>
        <v-text-field label="角色" v-model="roleInput"></v-text-field>
        <v-text-field
          label="经历描述"
          v-model="descriptionInput"
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
    startDate: Date,
    endDate: Date,
    institution: String,
    role: String,
    description: String,
  },
  data: function () {
    return {
      editing: false,
      submitting: false,
      deleting: false,
      titleInput: "",
      startDateInput: null,
      endDateInput: null,
      institutionInput: "",
      roleInput: "",
      descriptionInput: "",
    };
  },
  methods: {
    edit: function () {
      this.titleInput = this.title;
      this.startDateInput = this.startDate;
      this.endDateInput = this.endDate;
      this.institutionInput = this.institution;
      this.roleInput = this.role;
      this.descriptionInput = this.description;
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
          startDate: this.startDateInput,
          endDate: this.endDateInput,
          institution: this.institutionInput,
          role: this.roleInput,
          description: this.descriptionInput,
        }),
      };
      fetch(`/api/experiences/${this.id}`, requestOptions).then(() => {
        this.$emit("experience-changed");
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
      fetch(`/api/experiences/${this.id}`, requestOptions).then(() => {
        this.$emit("experience-changed");
        this.deleting = false;
      });
    },
  },
};
</script>

<style scoped>
</style>
