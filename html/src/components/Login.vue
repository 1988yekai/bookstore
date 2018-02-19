<template>
  <div class="login">
    <el-row>
      <label style=" width:50px">用户名:</label>
      <el-input v-model="username" placeholder="请输入用户名" style=" width:250px"></el-input>
    </el-row>
    <el-row class="password">
      <label style="width:50px">密　码:</label>
      <el-input v-model="password" placeholder="请输入密码" style="width:250px" type="password"></el-input>
    </el-row>
    <div class="sub">
      <el-button size="small" round type="primary" v-on:click="submit1">提交</el-button>
      <el-button size="small" round type="danger" v-on:click="reset">重置</el-button>
      <el-button size="small" round type="success" @click="dialogVisible = true">注册</el-button>
    </div>

    <el-dialog title="提示" :visible.sync="dialogVisible" width="30%" :before-close="handleClose">
      <span>这是一段信息</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>
  </div>


</template>

<script>
  export default {
    name: "Login",
    data() {
      return {
        username: "",
        password: "",
        dialogVisible: false
      };
    },
    methods: {
      handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {
          });
      },
      reset: function () {
        this.username = "";
        this.password = "";
      },
      submit1: function () {
        var url = "http://localhost:8090/bookstore/Login/isLogin";
        var formData = new FormData();

        // append string
        formData.append('username', this.username);
        formData.append('password', this.password);

        //在vue-resources中会自动在路径上加入callback的函数名，得到的结果就是result
        this.$http.post(url, formData).then(function (result) {
          var res = result.body;
          if (res.login == 'ok') {
            // http://localhost:8080/one.html
            alert("登录成功！");
            window.location.assign("http://localhost:8080/one.html")
          }
        });
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
