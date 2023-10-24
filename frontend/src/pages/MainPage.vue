<template>
    <div class="mainpage">
        <base-button mode="big-buttons">10 min unpaid break</base-button>
        <base-button mode="big-buttons">30 min unpaid break</base-button>
        <base-button v-if="!isClockedIn"  mode="big-buttons">Clock In</base-button>
        <base-button v-else  mode="big-buttons">Clock Out</base-button>
    </div>
</template>

<script>
export default {
    data(){
        return{
            user: '',
            isClockedIn: false
        };
    },
    beforeCreate(){
        console.log('before');
        //talk to backend to check if user is clocked in or not
    }
}
</script>

<style scoped>
.mainpage {
  text-align: center; /* Horizontally center the content */
  display: flex;
  flex-direction: column;
  align-items: center; /* Vertically center the content */
  height: 30vh; /* Set the height to 100% of the viewport height for vertical centering */
  justify-content: center; /* Center content both horizontally and vertically */
  background-color: white;
  margin-top: 10%;
  margin-left: 25%;
  margin-right: 25%;
}

</style>