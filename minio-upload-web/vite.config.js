import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import vueJsx from '@vitejs/plugin-vue-jsx'
import copy from 'rollup-plugin-copy'
// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue(), vueJsx(),copy({
    targets: [
      {src: 'node_modules/@liveqing/liveplayer-v3/dist/component/liveplayer-lib.min.js', dest: 'public/js'},
    ]
  })],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  }
})
