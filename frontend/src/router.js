import  { createRouter, createWebHistory } from 'vue-router';
import LogIn from './pages/LogIn.vue';
import MainPage from './pages/worker/MainPage.vue';
import ClockedIn from './pages/worker/ClockedIn.vue';

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {path: '/', redirect: '/login'},
        {path: '/login', component: LogIn},
        {path: '/main/:id', component: MainPage},
        {path: '/:id/ClockedIn', component: ClockedIn}
    ]
});


export default router;