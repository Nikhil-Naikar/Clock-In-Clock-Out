<template>
    <div class="clockedinpage">
        <h3>Have a great shift {{ user }}!</h3>
        <h3>Successfully Clocked In on <span class="highlight">{{ day }} {{ date }}</span> at <span class="highlight">{{ time }}</span></h3>
        <router-link to="/login"><base-button>Log Out</base-button></router-link>
    </div>
</template>

<script>
import BaseButton from '../../components/ui/BaseButton.vue';
export default {
  components: { BaseButton },
    data(){
        return{
            user: this.$route.params.id,
            time: '',
            date: '',
            daysOfTheWeek: ['Mon','Tue','Wed','Thu','Fri','Sat','Sun'],
            dayIndex: '',
        };
    },
    created(){
        const currentTime = new Date();
        const currentHour = currentTime.getHours();
        const currentMinute = currentTime.getMinutes();
        const currentYear = currentTime.getFullYear();
        this.dayIndex = currentTime.getDay().toString();
        const currentMonth = currentTime.getMonth() + 1; // Months are zero-based, so add 1
        const currentDay = currentTime.getDate();

        // Create a formatted date string in "YYYY-MM-DD" format
        const formattedDate = `${currentYear}-${currentMonth.toString().padStart(2, '0')}-${currentDay.toString().padStart(2, '0')}`;

        console.log(formattedDate);

        // Use String formatting to ensure leading zeros if needed
        const formattedTime = `${currentHour.toString().padStart(2, '0')}:${currentMinute.toString().padStart(2, '0')}`;

        this.time = formattedTime;
        this.date = formattedDate;
    },
    computed:{
        day(){
            return this.daysOfTheWeek[this.dayIndex-1];
        },
    }
}
</script>

<style scoped>
.clockedinpage {
  text-align: center; /* Horizontally center the content */
  display: flex;
  flex-direction: column;
  align-items: center; /* Vertically center the content */
  height: 30vh; /* Set the height to 100% of the viewport height for vertical centering */
  justify-content: center; /* Center content both horizontally and vertically */
  background-color: white;
  margin-top: 7%;
  margin-left: 25%;
  margin-right: 25%;
  border: 5px solid black;
}

.highlight{
    font-size: 30px;
    font-weight: bold;
    
}

h3{
    font-size: 25px;
    font-weight: lighter;
}
</style>