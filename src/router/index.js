import Vue from 'vue'
import VueRouter from 'vue-router'
import PManagement from '../views/PManagement.vue'
import CManagement from '../views/CManagement.vue'
import Sales from '../views/Sales.vue'


Vue.use(VueRouter)


const routes = [

  {
    path: '/pmanagement',
    name: 'PManagement',
    component: PManagement
  },  
  {
    path: '/cmanagement',
    name: 'CManagement',
    component: CManagement
    },
  {
    path: '/sales',
    name: 'Sales',
    component: Sales
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
  })
  
  export default router