<script setup>
import { ref, onMounted } from 'vue';
import axiosInstance from '../axios.js'; // axios 설정 파일을 가져옵니다.
import CommodityComponent from "../components/CommodityComponent.vue";

const rows = ref([]); // rows 데이터를 관리하는 ref
const sumPrice = ref();
onMounted(async () => {
  try {
    const response = await axiosInstance.get('/v1/commodity/lowest-price-by-category');
    rows.value = response.data.data.commodities;
    sumPrice.value = response.data.data.sumPrice.toLocaleString('ko-KR');
  } catch (error) {
    alert('서버에서 오류가 발생했습니다. 잠시 후 다시 시도해 주세요.');
  }
});
</script>

<template>
  <CommodityComponent :rows="rows" />
</template>

<style scoped>

</style>