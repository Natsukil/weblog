import '@/assets/main.css'

import { createApp } from 'vue'
import './style.css'
// 导入路由
import router from '@/router'

import App from '@/App.vue'

createApp(App)
    .use(router)
    .mount('#app')
