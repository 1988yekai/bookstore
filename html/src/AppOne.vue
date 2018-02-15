<template>
  <div id="app">
    <!-- <img src="./assets/logo.png">//fa fa-book -->
    <h1 class="titlestyle"> AppOnePage </h1>
    <one/>
  </div>
</template>

<script>
// import HelloWorld from './components/HelloWorld'
import One from './components/One.vue'

export default {
  name: 'AppOne',
  components: {
    One
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
