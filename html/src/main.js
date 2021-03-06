/* jshint esversion: 6 */
// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue';
import App from './App';
import ElementUI from 'element-ui';
// import { Button, Select, Input, Row, Col, Form, FormItem, Dialog, Alert, MessageBox } from 'element-ui';
import 'font-awesome/css/font-awesome.css';
// var VueResource = require('vue-resource');
/*
import list from './list'; //es6写法
//等价于
var list = require('./list');
 */

import VueResource from 'vue-resource';

Vue.use(VueResource);
Vue.use(ElementUI);
// Vue.use(Button);
// Vue.use(Input);
// Vue.use(Row);
// Vue.use(Col);
// Vue.use(Dialog);
// Vue.use(Alert);

// Vue.http.options.emulateJSON = true;
Vue.config.productionTip = false;

/* eslint-disable no-new */
new Vue({
    el: '#app',
    components: { App },
    template: '<App/>'
});