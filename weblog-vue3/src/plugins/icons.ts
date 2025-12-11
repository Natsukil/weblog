// src/plugins/icons.ts
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import { type App } from 'vue'

export function setupIcons(app: App) {
  for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
  }
}

// 然后在 main.ts 中使用：
// import { setupIcons } from './plugins/icons'
// setupIcons(app)