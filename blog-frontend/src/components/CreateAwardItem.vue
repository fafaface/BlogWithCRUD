<template>
  <div class="award-container">
    <div class="award-edit">
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
            <span class="headline">添加奖项</span>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-col cols="20" sm="8" md="12">
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
      awardDateInput: null,
      dialog: false,
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
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${this.$store.state.accessToken}`,
        },
        body: JSON.stringify({
          type: this.typeInput,
          title: this.titleInput,
          awardDate: this.awardDateInput,
        }),
      };
      fetch(`/api/awards/`, requestOptions).then(() => {
        this.$emit("award-changed");
        this.dialog = false;
        this.submitting = false;
        this.titleInput = "";
        this.awardDateInput = null;
      });
    },
  },
};
</script>

<style scoped>
.award-container {
  max-width: 960px;
}

.award-edit {
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
