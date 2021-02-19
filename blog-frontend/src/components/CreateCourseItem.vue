<template>
  <div class="course-container">
    <div class="course-edit">
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
            <span class="headline">添加课程</span>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-col cols="20" sm="8" md="12">
                <v-text-field
                  v-model="nameInput"
                  label="课程名"
                  required
                ></v-text-field>
          
                <v-text-field
                  label="成绩"
                  type ="number"
                  v-model="gradeInput"
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
      nameInput: "",
      gradeInput: 0,
      dialog: false,
    };
  },
  methods: {
    edit: function () {
      this.nameInput = this.name;
      this.gradeInput = this.grade;
      this.editing = true;
    },

    submit: function () {
      this.submitting = true;
      const requestOptions = {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          "Authorization": `Bearer ${this.$store.state.accessToken}`,
        },
        body: JSON.stringify({
          type: this.typeInput,
          name: this.nameInput,
          grade: parseFloat(this.gradeInput),
        }),
      };
      fetch(`/api/courses/`, requestOptions).then(() => {
        this.$emit("course-changed");
        this.dialog = false;
        this.submitting = false;
        this.nameInput = "";
        this.gradeInput = 0;
      });
    },
  },
};
</script>

<style scoped>
.course-container {
  max-width: 960px;
}

.course-edit {
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
