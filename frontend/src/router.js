import  { createRouter, createWebHistory } from 'vue-router';
import LogIn from './pages/LogIn.vue';
import MainPage from './pages/worker/MainPage.vue';
import ClockedInOut from './pages/worker/ClockedInOut.vue';

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {path: '/', redirect: '/login'},
        {path: '/login', component: LogIn},
        {path: '/main/:id', component: MainPage},
        {path: '/:id/ClockedInOut', component: ClockedInOut}
    ]
});


export default router;