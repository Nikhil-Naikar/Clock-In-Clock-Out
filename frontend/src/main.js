import { createApp } from 'vue'
import App from './App.vue'
import router from './router.js';
import BaseButton from '../src/components/ui/BaseButton.vue';
import { createPinia } from 'pinia'


const app = createApp(App);
const pinia = createPinia()

app.use(router);
app.use(pinia);
app.component('base-button', BaseButton);
app.mount('#app')
