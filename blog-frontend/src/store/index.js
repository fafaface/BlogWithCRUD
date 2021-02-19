import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    accessToken: null,
    username: null,
    email: null,
    roles: null
  },
  getters: {
    isSignedIn: state => !!state.accessToken,
    isAdmin: state => {
      return state.roles && state.roles.includes('ROLE_ADMIN')
    }
  },
  mutations: {
    SIGN_IN(state, { accessToken, username, email, roles }) {
      state.accessToken = accessToken
      state.username = username
      state.email = email
      state.roles = roles
    },

    SIGN_OUT(state) {
      state.accessToken = null
      state.username = null
      state.email = null
      state.roles = null
    }
  },
  actions: {
  },
  modules: {
  }
})
