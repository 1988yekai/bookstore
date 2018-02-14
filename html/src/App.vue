<template>
  <div id="app">
    <!-- <img src="./assets/logo.png">//fa fa-book -->
    <h1 class="titlestyle"> 欢迎使用我的书店后台管理系统 </h1>
    <i class="fa fa-book" style="font-size:200px;color:red;"></i>
    <Login/>
  </div>
</template>

<script>
// import HelloWorld from './components/HelloWorld'
import Login from './components/Login'

export default {
  name: 'App',
  components: {
    Login
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  /* color: #2c3e50; */
  margin-top: 60px;
}
.titlestyle{
  color: #2c3e50;
}

</style>
