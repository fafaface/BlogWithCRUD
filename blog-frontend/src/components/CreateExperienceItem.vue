<template>
  <div class="experience-container">
    <div class="experience-edit">
      <v-dialog v-model="dialog" persistent max-width="600px">
        <template v-slot:activator="{ on, attrs }">
          <v-fab-transition>
            <v-btn
              color="primary"
              dark
              elevation="2"
              fab
              fixed
              right
              v-bind="attrs"
              v-on="on"
              class="createButton"
            >
              <v-icon dark> mdi-plus </v-icon>
            </v-btn>
          </v-fab-transition>
        </template>
        <v-card>
          <v-card-title>
            <span class="headline">添加研究经历</span>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-col cols="20" sm="8" md="12">
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
              </v-col>
            </v-container>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
              color="blue darken-1"
              text
              :disabled="submitting"
              @click="dialog = false"
            >
              取消
            </v-btn>
            <v-btn
              color="blue darken-1"
              text
              :loading="submitting"
              v-on:click="submit"
            >
              提交
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </div>
  </div>
</template>

<script>
export default {
  data: function () {
    return {
      editing: false,
      submitting: false,
      titleInput: "",
      startDateInput: null,
      endDateInput: null,
      institutionInput: "",
      roleInput: "",
      descriptionInput: "",
      dialog: false,
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
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${this.$store.state.accessToken}`,
        },
        body: JSON.stringify({
          title: this.titleInput,
          startDate: this.startDateInput,
          endDate: this.endDateInput,
          institution: this.institutionInput,
          role: this.roleInput,
          description: this.descriptionInput,
        }),
      };
      fetch(`/api/experiences/`, requestOptions).then(() => {
        this.$emit("experience-changed");
        this.dialog = false;
        this.submitting = false;
        this.titleInput = "";
        this.startDateInput = null;
        this.endDateInput = null;
        this.institutionInput = "";
        this.roleInput = "";
        this.descriptionInput = "";
      });
    },
  },
};
</script>

<style scoped>
.experience-container {
  max-width: 960px;
}

.experience-edit {
  display: flex;
  flex-direction: column;
  border-style: solid;
  margin-bottom: 20px;
  border-color: rgba(255, 255, 255, 0.863);
}
.createButton {
  bottom: 80px;
}
</style>
