<template>
  <div class="content-container">
    <div class="cotent-edit">
        <v-card>
          <v-card-text>
            <v-text-field
              label="用户名"
              v-model="usernameInput"
              clearable
              clear-icon="mdi-close-circle"
            ></v-text-field>

            <v-text-field
              label="密码"
              
              v-model="passwordInput"
              clearable
              clear-icon="mdi-close-circle"
            ></v-text-field>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="blue darken-1" text @click="dialog = false">
              取消
            </v-btn>
            <v-btn color="blue darken-1" text v-on:click="submit"> 登录 </v-btn>
          </v-card-actions>
        </v-card>
    </div>
  </div>
</template>


<script>
export default {
  data: function () {
    return {
      editing: false,
      dialog: false,
      usernameInput: "",
      passwordInput: "",
      hidden: false,
    };
  },
  methods: {
    submit: async function () {
      this.editing = false;
      this.dialog = false;
      const requestOptions = {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          username: this.usernameInput,
          password: this.passwordInput,
        }),
      };
      const resp = await fetch(`/api/auth/signin`, requestOptions);
      const respData = await resp.json();
      console.log(respData);

      this.usernameInput = "";
      this.passwordInput = "";
    },
  },
};
</script>

<style scoped>
.createButton {
  bottom: 120px;
}
</style>