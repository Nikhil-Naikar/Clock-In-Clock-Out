<template>
    <button :class="mode">
        <slot>
        </slot>
    </button>
</template>

<script>
export default {
  props: ["mode"]
}
</script>

<style scoped>
button{
  text-decoration: none;
  padding: 0.5rem 1rem;
  font-size: 1.25rem;
  font-weight: bolder;
  background-color: rgb(3, 107, 128);
  border: 1px solid rgb(98, 189, 207);
  color: white;
  cursor: pointer;
  display: inline-block;
}

button:hover,
button:active {
  background-color: rgb(98, 189, 207);
  border-color: rgb(98, 189, 207);
}

.big-buttons {
  width: 90%;
  /* height: 30%; */
  height: auto;
}

.tall-buttons{
  width: 90%;
  /* height: 45%; */
  height: auto;
}
</style>