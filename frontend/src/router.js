import  { createRouter, createWebHistory } from 'vue-router';
import LogIn from './pages/LogIn.vue';
import MainPage from './pages/MainPage.vue';

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {path: '/', redirect: '/login'},
        {path: '/login', component: LogIn},
        {path: '/main/:id', component: MainPage}
    ]
});


export default router;