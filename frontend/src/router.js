import  { createRouter, createWebHistory } from 'vue-router';
import LogIn from './pages/LogIn.vue';
import MainPage from './pages/worker/MainPage.vue';
import ClockedIn from './pages/worker/ClockedIn.vue';
import ClockedOut from './pages/worker/ClockedOut.vue';

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {path: '/', redirect: '/login'},
        {path: '/login', component: LogIn},
        {path: '/main/:id/:isClockedIn', component: MainPage},
        {path: '/:id/ClockedIn', component: ClockedIn},
        {path: '/:id/ClockedOut', component: ClockedOut}
    ]
});


export default router;