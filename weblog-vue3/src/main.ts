import '@/assets/main.css'

import { createApp } from 'vue'
import './style.css'
// 导入路由
import router from '@/router'


import App from '@/App.vue'

const app = createApp(App)

import { setupIcons } from './plugins/icons'
setupIcons(app)


app.use(router)
app.mount('#app')
