import  { createRouter, createWebHistory } from 'vue-router';
// Below are all of my customs components
import LogIn from './pages/LogIn.vue';
import MainPage from './pages/worker/MainPage.vue';
import ClockedIn from './pages/worker/ClockedIn.vue';
import ClockedOut from './pages/worker/ClockedOut.vue';
// import ShiftFeedback from './pages/worker/ShiftFeedback.vue';

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {path: '/', redirect: '/login'},
        {path: '/login', component: LogIn},
        {path: '/main/:id/:isClockedIn', component: MainPage},
        {path: '/:id/ClockedIn', component: ClockedIn},
        {path: '/:id/ClockedOut', component: ClockedOut}
        // {path: '/:id/feedback', component: ShiftFeedback}
    ]
});


export default router;