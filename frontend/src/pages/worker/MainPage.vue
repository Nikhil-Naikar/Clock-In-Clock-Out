<template>
    <div class="mainpage">
        <div class="grid-container">
            <div class="selection-container">
                <p>{{ greeting }} {{ user }}!</p>
            </div>
            <div class="selection-container">
                <router-link to="/login"><base-button>Log Out</base-button></router-link>
            </div>
            <div class="selection-container">
                <p class="date-time-info"><img src="../../assets/clock.png"> <span>{{date}}</span> <span>{{time}}</span></p>
            </div>
            <div class="button-container">
                    <div v-if="!isClockedIn">
                        <p class="question">What would you like to do?</p>
                        <base-button class="flex-button" mode="tall-buttons" @click="startShift">🕣↶ Clock In <span>→</span></base-button>
                        <base-button class="flex-button" mode="tall-buttons">💰📚 View PayRoll History <span>→</span></base-button>
                    </div>
                    <div v-else>
                        <p class="question">What would you like to do?</p>
                        <base-button class="more-height flex-button" mode="big-buttons">☕️ 10 minute break <span>→</span></base-button>
                        <base-button class="more-height flex-button" mode="big-buttons">☕️ 30 minute break <span>→</span></base-button>
                        <base-button class="more-height flex-button" mode="big-buttons" @click="endShift">🕣↷ Clock Out <span>→</span></base-button>
                        <base-button class="more-height flex-button" mode="big-buttons">💰📚 View PayRoll History <span>→</span></base-button>
                    </div>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
import BaseButton from '../../components/ui/BaseButton.vue';

export default {
  components: { BaseButton },
    data(){
        return{
            user: null,
            isClockedIn: null,
            greeting: 'Good Morning',
            date: '',
            time: '',
            pin: '',
        };
    },
    methods:{
        startShift(){
            
            this.pin = Number(this.$route.query.pin);
            let start_time = this.getTime();
            let sqlDate = this.getDateForSql();
            console.log('checking = ' + sqlDate);
            axios.post('http://localhost:1111/data/ClockInUser', {
                // Request body data
                "pin": this.pin,
                "date": sqlDate,
                "time": start_time
            })
            .catch(error => {
                // Handle error
                console.error('There was an error!', error);
            });

            this.$router.push('/'+this.user+'/ClockedIn');
        },
        endShift(){
            this.$router.push('/'+this.user+'/ClockedOut');
        },
        getTime(){
            const currentTime = new Date();
            let hours = currentTime.getHours();
            let minutes = currentTime.getMinutes();
            if (hours === 0){
                hours = 12
            }
            minutes = minutes < 10 ? '0' + minutes : minutes;
            return hours + ':' + minutes;
        },
        getDateForSql(){
            const currentTime = new Date();
            let year = currentTime.getFullYear()
            let month = currentTime.getMonth() < 10 ? '0' + currentTime.getMonth() : currentTime.getMonth();
            let day = currentTime.getDay() < 10 ? '0' + currentTime.getDay() : currentTime.getDay();
            return year + '-' + month + '-' + day;
        }
    },
    created(){
        this.isClockedIn = this.$route.params.isClockedIn === 'true';
        this.user = this.$route.params.id;
        const currentTime = new Date();
        // Get the day
        const daysOfWeek = ["Sunday", "Monday", "Tueday", "Wednesday", "Thursday", "Friday", "Saturday"];
        const day = daysOfWeek[currentTime.getDay()];
        // Get the month
        const monthsOfYear = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
        const month = monthsOfYear[currentTime.getMonth()];
        // Get the date
        const date = currentTime.getDate();
        this.date = day + ', ' + month + ' ' + date;
        let hours = currentTime.getHours();
        let minutes = currentTime.getMinutes();
        const ampm = hours >= 12 ? 'PM' : 'AM';
        hours = hours % 12 || 12; // Handle midnight (0 hours) and noon (12 hours)
        minutes = minutes < 10 ? '0' + minutes : minutes; // Add leading zero to minutes if less than 10
        this.time = hours + ':' + minutes + ' ' + ampm;
        const currentHour = currentTime.getHours();
        if(currentHour >= 0 && currentHour < 12){
            this.greeting = 'Good Morning';
        }
        else if(currentHour >= 12 && currentHour < 18){
            this.greeting = 'Good Afternoon';
        }
        else{
            this.greeting = 'Good Evening';
        }
    }
}
</script>

<style scoped>
.mainpage {
  height: auto; /* Set the height to 100% of the viewport height for vertical centering */
  justify-content: center; 
  background-color: white;
  margin-left: 20%;
  margin-right: 20%;
  border-radius: 0%;
  border: 5px solid black;
}

.question{
    font-size: 1.5rem;
    font-weight: bolder;
    margin-bottom: 10px;
}

.date-time-info{
    display: flex;
    flex-direction: column;
}

.flex-button{
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.grid-container {
    display: grid;
    grid-template-columns: 50% 50%;
    padding: 30px;
}

img {
    max-width: 100%;
    height: auto;
}

.selection-container {
    display: flex;
    flex-direction: column;
    text-align: center;
    align-items: center;
    justify-content: center;
}
.button-container{
    display: flex;
    flex-direction: column;
}
.button-container .question{
    display: flex;
    justify-content: flex-start;
}


p {
    font-size: 30px;
    font-weight: bolder;
}

.menu {
    display: flex;
    justify-content: space-evenly;
    align-items: center;
    padding: 20px;
    padding-right: 50px;

}



</style>