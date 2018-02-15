import Vue from 'vue'
import AppOne from './AppOne.vue'

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
    el: '#app',
    render: h => h(AppOne)
})