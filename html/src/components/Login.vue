

<template>
  <div class="login">
    <el-row>
     <!-- <el-col :span="12" :offset="6"><div class="grid-content bg-purple"> <label for="username" class="label">用户名:</label> <el-input v-model="username" placeholder="请输入用户名" style="inputwidth"></el-input></div></el-col> -->
      <label for="username" style="float:letf; width:50px">用户名:</label> <el-input v-model="username" placeholder="请输入用户名" style="float:letf; width:250px"></el-input>
    </el-row>
    <el-row class="password">
        <label for="password" style="float:letf; width:50px">密　码:</label> <el-input v-model="password" placeholder="请输入密码" style="float:letf; width:250px"></el-input>
    </el-row>
    <div class="sub">
        <el-button size="small" round type="primary">提交</el-button> <el-button size="small" round type="danger" v-on:click="reset">重置</el-button>
    </div>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      username: "",
      password: ""
    };
  },
  methods: {
    reset: function() {
      this.username = "";
      this.password = "";
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.password {
  margin-top: 10px;
  margin-bottom: 10px;
}

</style>
