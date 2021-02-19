<template>
  <div class="content-container">
    <div class="cotent-edit">
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
              bottom
            >
              <v-icon dark> mdi-account-circle </v-icon>
            </v-btn>
          </v-fab-transition>
        </template>

        <v-tabs v-model="tab">
          <v-tab>登录</v-tab>
          <v-tab>注册</v-tab>
        </v-tabs>

        <v-tabs-items v-model="tab">
          <v-tab-item>
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
                   type="password"
                  v-model="passwordInput"
                  clearable
                  clear-icon="mdi-close-circle"
                ></v-text-field>
              </v-card-text>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn
                  :disabled="loading"
                  color="blue darken-1"
                  text
                  @click="dialog = false"
                >
                  取消
                </v-btn>
                <v-btn
                  :loading="loading"
                  color="blue darken-1"
                  text
                  v-on:click="signin"
                >
                  登录
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-tab-item>
          <v-tab-item>
            <v-card>
              <v-card-text>
                <v-text-field
                  label="用户名"
                  v-model="usernameInput"
                  clearable
                  clear-icon="mdi-close-circle"
                ></v-text-field>
                <v-text-field
                  label="邮箱"
                  v-model="emailInput"
                  clearable
                  clear-icon="mdi-close-circle"
                ></v-text-field>
                <v-text-field
                  label="密码"
                   type="password"
                  v-model="passwordInput"
                  clearable
                  clear-icon="mdi-close-circle"
                ></v-text-field>
                <v-checkbox
                  v-model="isAdmin"
                  label="注册为管理员用户"
                ></v-checkbox>
              </v-card-text>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn
                  :disabled="loading"
                  color="blue darken-1"
                  text
                  @click="dialog = false"
                >
                  取消
                </v-btn>
                <v-btn
                  :loading="loading"
                  color="blue darken-1"
                  text
                  v-on:click="signup"
                >
                  注册
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-tab-item>
        </v-tabs-items>
      </v-dialog>
      <v-snackbar v-model="snackbar" timeout="2000">
        {{ message }}
      </v-snackbar>
    </div>
  </div>
</template>


<script>
export default {
  data: function () {
    return {
      isAdmin: false,
      model: "tab",
      dialog: false,
      usernameInput: "",
      passwordInput: "",
      emailInput: "",
      hidden: false,
      tab: null,
      loading: false,
      snackbar: false,
      message: "",
    };
  },
  methods: {
    signup: async function () {
      const role = ["user"];
      if (this.isAdmin) {
        role.push("admin");
      }
      const requestOptions = {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          username: this.usernameInput,
          email: this.emailInput,
          password: this.passwordInput,
          role: role,
        }),
      };

      this.loading = true;
      const resp = await fetch(`/api/auth/signup`, requestOptions);
      this.loading = false;

      if (!resp.ok) {
        this.message = "注册失败";
        this.snackbar = true;
        return;
      }
      this.message = "注册成功";
      this.snackbar = true;

      this.dialog = false;

      this.usernameInput = "";
      this.passwordInput = "";
      this.emailInput = "";
    },

    signin: async function () {
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

      this.loading = true;
      const resp = await fetch(`/api/auth/signin`, requestOptions);
      this.loading = false;

      if (!resp.ok) {
        this.message = "登录失败";
        this.snackbar = true;
        return;
      }
      this.message = "登录成功";
      this.snackbar = true;
      const respData = await resp.json();

      this.$store.commit("SIGN_IN", {
        accessToken: respData.accessToken,
        username: respData.username,
        email: respData.email,
        roles: respData.roles,
      });

      this.dialog = false;

      this.usernameInput = "";
      this.passwordInput = "";
    },
  },
};
</script>

<style scoped>
</style>