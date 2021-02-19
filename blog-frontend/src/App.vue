<template>
  <v-app>
    <CreateUser />

    <v-app-bar app elevate-on-scroll>
      <v-toolbar-title>连月菡的博客</v-toolbar-title>
      <v-spacer />
      <v-btn text to="/">主页</v-btn> |
      <v-btn text to="/about">个人简介</v-btn> |
      <v-btn text to="/resume">个人核心竞争力</v-btn> |
      <v-btn text to="/hometown">家乡简介</v-btn> |
      <v-btn text to="/spots">特色介绍</v-btn> |
      <v-btn text to="/board">留言板</v-btn> |
      <v-chip
        class="ml-4"
        color="secondary"
        v-if="$store.getters.isSignedIn && !$store.getters.isAdmin"
      >
        普通用户 {{ $store.state.username }}
      </v-chip>
      <v-chip
        class="ml-4"
        color="primary"
        v-if="$store.getters.isSignedIn && $store.getters.isAdmin"
      >
        管理员 {{ $store.state.username }}
      </v-chip>
      <v-chip class="ml-4" v-if="!$store.getters.isSignedIn"> 未登录 </v-chip>
    </v-app-bar>

    <!-- Sizes your content based upon application components -->
    <v-main>
      <v-container fluid>
        <router-view></router-view>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import CreateUser from "./components/CreateUser.vue";
export default {
  components: {
    CreateUser,
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
</style>
