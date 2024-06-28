import { defineStore } from 'pinia'

export const useStorageStore = defineStore('storage', {
  state: () => ({
    name: '',
    pin: '',
    status: '',
    date: '',
    time: ''
  }),
  getters: {
    getName(state){
        return state.name;
    },
    getPin(state){
        return state.pin;
    },
    getStatus(state){
        return state.status;
    },
    getDate(state){
        if (state.date === ''){
            const currentTime = new Date();
            // Get the day
            const daysOfWeek = ["Sunday", "Monday", "Tueday", "Wednesday", "Thursday", "Friday", "Saturday"];
            const day = daysOfWeek[currentTime.getDay()];
            // Get the month
            const monthsOfYear = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
            const month = monthsOfYear[currentTime.getMonth()];
            // Get the date
            const date = currentTime.getDate();
            state.date = day + ', ' + month + ' ' + date;
        }
        return state.date;
    },
    getTime(state){
        if (state.time === ''){
            const currentTime = new Date();
            let hours = currentTime.getHours();
            let minutes = currentTime.getMinutes();
            const ampm = hours >= 12 ? 'PM' : 'AM';
            hours = hours % 12 || 12; // Handle midnight (0 hours) and noon (12 hours)
            minutes = minutes < 10 ? '0' + minutes : minutes; // Add leading zero to minutes if less than 10
            state.time = hours + ':' + minutes + ' ' + ampm;
        }
        return state.time;
    }
  },
  actions: {
    setName(name){
        this.name = name;
    },
    setPin(pin){
        this.pin = pin;
    },
    setStatus(status){
        this.status = status;
    },
    switchDateFormat(){
        const currentTime = new Date();
        let year = currentTime.getFullYear()
        let month = currentTime.getMonth() < 10 ? '0' + currentTime.getMonth() : currentTime.getMonth();
        let day = currentTime.getDay() < 10 ? '0' + currentTime.getDay() : currentTime.getDay();
        return year + '-' + month + '-' + day;
    },
    switchTimeFormat(){
        const currentTime = new Date();
        let hours = currentTime.getHours();
        let minutes = currentTime.getMinutes();
        if (hours === 0){
            hours = 12
        }
        minutes = minutes < 10 ? '0' + minutes : minutes;
        return hours + ':' + minutes;
    }
  }
})