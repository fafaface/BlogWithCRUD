<template>
  <div class="spot-container">
    <div class="spot-edit">
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
              v-show="!hidden"
              class="createButton"
            >
              <v-icon dark> mdi-plus </v-icon>
            </v-btn>
          </v-fab-transition>
        </template>
        <v-card>
          <v-card-title>
            <span class="headline">添加特色内容</span>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-col cols="20" sm="8" md="12">
                <v-text-field
                  v-model="titleInput"
                  label="标题"
                  required
                ></v-text-field>
                <v-text-field
                  v-model="imgurlInput"
                  label="图片链接"
                  required
                ></v-text-field>
                <v-select
                  v-model="typeInput"
                  label="类型"
                  :items="items"
                  required
                ></v-select>
                <v-textarea
                  label="内容"
                  hint="对特色的详细介绍"
                  v-model="descriptionInput"
                ></v-textarea>
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
      typeInput: "美食",
      titleInput: "",
      descriptionInput: "",
      imgurlInput: "",
      items: ["美食", "美景", "风土人情"],
      dialog: false,
      hidden: false,
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
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${this.$store.state.accessToken}`,
        },
        body: JSON.stringify({
          type: this.typeInput,
          title: this.titleInput,
          description: this.descriptionInput,
          imgurl: this.imgurlInput,
        }),
      };
      fetch(`/api/spots/`, requestOptions).then(() => {
        this.$emit("spot-changed");
        this.dialog = false;
        this.submitting = false;
        this.typeInput = "美食";
        this.titleInput = "";
        this.descriptionInput = "";
        this.imgurlInput = "";
      });
    },
  },
};
</script>

<style scoped>
.spot-container {
  max-width: 960px;
}

.spot-edit {
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
