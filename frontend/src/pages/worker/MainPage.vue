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
                <img src="../../assets/clock.png">
            </div>
            <div class="button-container">
                    <p class="small-text">What would you like to do?</p>
                    <base-button class="more-height flex-button" mode="big-buttons">☕️ 10 minute break <span>→</span></base-button>
                    <base-button class="more-height flex-button" mode="big-buttons">☕️ 30 minute break <span>→</span></base-button>
                    <base-button class="more-height flex-button" v-if="!isClockedIn"  mode="big-buttons" @click="startShift">🕣↶ Clock In <span>→</span></base-button>
                    <base-button class="more-height flex-button" v-else  mode="big-buttons" @click="endShift">🕣↷ Clock Out <span>→</span></base-button>
                    <base-button class="more-height flex-button" mode="big-buttons">💰📚 View PayRoll History <span>→</span></base-button>
            </div>
        </div>
    </div>
</template>

<script>
import BaseButton from '../../components/ui/BaseButton.vue';
export default {
  components: { BaseButton },
    data(){
        return{
            user: this.$route.params.id,
            isClockedIn: false,
            greeting: 'Good Morning'
        };
    },
    // created(){
    //     //talk to backend to check if user is clocked in or not
    // },
    methods:{
        startShift(){
            this.$router.push('/'+this.user+'/ClockedIn');
        },
        endShift(){
            this.$router.push('/'+this.user+'/ClockedOut');
        },
    },
    created(){
        const currentTime = new Date();
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

.small-text{
    font-size: 1.25rem;
    font-weight: bold;
    margin-bottom: 10px;
}

.flex-button{
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.grid-container {
    display: grid;
    grid-template-columns: 60% 40%;
    padding-right: 30px;
    padding-left: 30px;
    padding-bottom: 30px;
}

img {
    max-width: 100%;
    height: auto;
    display: flex;
    flex-direction: column;
    text-align: center;
    align-items: center;
    justify-content: center;
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
.button-container .small-text{
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