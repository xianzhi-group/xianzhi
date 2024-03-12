<template>
  <div class="login">
    <!--    <a-row align="stretch" class="login-box">-->
    <!--      <a-col :xs="0" :sm="12" :md="15">-->
    <!--        <div class="login-left">-->
    <!--          <img class="login-left__img" src="@/assets/svgs/login-img.svg" />-->
    <!--        </div>-->
    <!--      </a-col>-->
    <!--&lt;!&ndash;      <a-col :xs="24" :sm="12" :md="9">&ndash;&gt;-->
    <!--&lt;!&ndash;        <div class="login-right">&ndash;&gt;-->
    <!--&lt;!&ndash;          <a-form&ndash;&gt;-->
    <!--&lt;!&ndash;              ref="formRef"&ndash;&gt;-->
    <!--&lt;!&ndash;              :size="'medium'"&ndash;&gt;-->
    <!--&lt;!&ndash;              :model="form"&ndash;&gt;-->
    <!--&lt;!&ndash;              :style="{ width: '84%' }"&ndash;&gt;-->
    <!--&lt;!&ndash;              :label-col-style="{ display: 'none' }"&ndash;&gt;-->
    <!--&lt;!&ndash;              :wrapper-col-style="{ flex: 1 }"&ndash;&gt;-->
    <!--&lt;!&ndash;          >&ndash;&gt;-->
    <!--&lt;!&ndash;            <h3 class="login-right__title">&ndash;&gt;-->
    <!--&lt;!&ndash;              <img class="logo" src="@/assets/images/logo.gif" /><span>Admin Pro</span>&ndash;&gt;-->
    <!--&lt;!&ndash;            </h3>&ndash;&gt;-->
    <!--&lt;!&ndash;            <a-form-item field="username">&ndash;&gt;-->
    <!--&lt;!&ndash;              <a-input v-model="form.username" placeholder="账号 admin/user" allow-clear>&ndash;&gt;-->
    <!--&lt;!&ndash;                <template #prefix><icon-user :stroke-width="1" :style="{ fontSize: '20px' }" /></template>&ndash;&gt;-->
    <!--&lt;!&ndash;              </a-input>&ndash;&gt;-->
    <!--&lt;!&ndash;            </a-form-item>&ndash;&gt;-->
    <!--&lt;!&ndash;            <a-form-item field="password">&ndash;&gt;-->
    <!--&lt;!&ndash;              <a-input-password v-model="form.password" placeholder="密码" allow-clear>&ndash;&gt;-->
    <!--&lt;!&ndash;                <template #prefix><icon-lock :stroke-width="1" :style="{ fontSize: '20px' }" /></template>&ndash;&gt;-->
    <!--&lt;!&ndash;              </a-input-password>&ndash;&gt;-->
    <!--&lt;!&ndash;            </a-form-item>&ndash;&gt;-->
    <!--&lt;!&ndash;            <a-form-item>&ndash;&gt;-->
    <!--&lt;!&ndash;              <a-row justify="space-between" align="center" class="w-full">&ndash;&gt;-->
    <!--&lt;!&ndash;                <a-checkbox >记住密码</a-checkbox>&ndash;&gt;-->
    <!--&lt;!&ndash;                <a-link>忘记密码</a-link>&ndash;&gt;-->
    <!--&lt;!&ndash;              </a-row>&ndash;&gt;-->
    <!--&lt;!&ndash;            </a-form-item>&ndash;&gt;-->
    <!--&lt;!&ndash;            <a-form-item>&ndash;&gt;-->
    <!--&lt;!&ndash;              <a-space direction="vertical" fill class="w-full">&ndash;&gt;-->
    <!--&lt;!&ndash;                <a-button type="primary" size="large" long :loading="false" >登录</a-button>&ndash;&gt;-->
    <!--&lt;!&ndash;                <a-button type="text" size="large" long class="register-btn">注册账号</a-button>&ndash;&gt;-->
    <!--&lt;!&ndash;              </a-space>&ndash;&gt;-->
    <!--&lt;!&ndash;            </a-form-item>&ndash;&gt;-->
    <!--&lt;!&ndash;          </a-form>&ndash;&gt;-->
    <!--&lt;!&ndash;        </div>&ndash;&gt;-->
    <!--&lt;!&ndash;      </a-col>&ndash;&gt;-->
    <!--    </a-row>-->


    <LoginBg></LoginBg>
  </div>
</template>

<script setup lang="ts">
// import { useUserStore } from '@/stores'
// import { useLoading } from '@/hooks'
// import { Message, type FormInstance } from '@arco-design/web-vue'
import LoginBg from '@/views/login/components/LoginBg/index.vue'
// import * as Regexp from '@/utils/regexp'
// import { isMobile } from '@/utils'
import {useRouter} from "vue-router";
import {reactive} from "vue";

defineOptions({name: 'Login'})
const router = useRouter()
// const userStore = useUserStore()

const form = reactive({
  username: 'admin',
  password: '123456'
})
</script>

<style lang="scss" scoped>
.login {
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: var(--color-bg-5);

  &-box {
    width: 86%;
    max-width: 720px;
    height: 380px;
    display: flex;
    z-index: 999;
    box-shadow: 0 2px 4px 2px rgba(0, 0, 0, 0.08);
  }
}

.login-left {
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  position: relative;
  overflow: hidden;
  background: linear-gradient(60deg, rgb(var(--primary-6)), rgb(var(--primary-3)));

  &__img {
    width: 100%;
    height: 100%;
    position: absolute;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    transition: all 0.3s;
    object-fit: cover;
  }
}

.login-right {
  width: 100%;
  height: 100%;
  background: var(--color-bg-1);
  display: flex;
  justify-content: center;
  align-items: center;
  padding-top: 30px;
  box-sizing: border-box;

  &__title {
    color: var(--color-text-1);
    font-weight: 500;
    font-size: 20px;
    line-height: 32px;
    margin-bottom: 20px;
    text-align: center;
    display: flex;
    justify-content: center;
    align-items: center;

    .logo {
      width: 32px;
      height: 32px;
      margin-right: 6px;
    }
  }
}

.register-btn,
.register-btn:hover {
  color: var(--color-text-2);
}

.theme-btn {
  position: fixed;
  top: 20px;
  left: 30px;
  z-index: 9999;
}
</style>