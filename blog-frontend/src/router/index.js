import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/board',
    name: 'Board',
    component: () => import(/* webpackChunkName: "board" */ '../views/Board.vue')
  },
  {
    path: '/hometown',
    name: 'Hometown',
    component: () => import(/* webpackChunkName: "hometown" */ '../views/Hometown.vue')
  },
  {
    path: '/resume',
    name: 'Resume',
    component: () => import(/* webpackChunkName: "resume" */ '../views/Resume.vue')
  },
  {
    path: '/spots',
    name: 'Spots',
    component: () => import(/* webpackChunkName: "spots" */ '../views/Spots.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
