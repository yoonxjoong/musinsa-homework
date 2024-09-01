<script setup>
import { ref, onMounted } from 'vue';
import axiosInstance from '../axios.js';
import CommodityComponent2 from "../components/CommodityComponent2.vue";

const rows = ref([]);
const sumPrice = ref();
const brandNm = ref();

onMounted(async () => {
  try {
    const response = await axiosInstance.get('/v1/commodity/lowest-sum-price-by-brand');
    rows.value = response.data.data.commodities;
    sumPrice.value = response.data.data.sumPrice.toLocaleString('ko-KR');
    brandNm.value = response.data.data.brandNm;
    console.log(response)
  } catch (error) {
    console.error('Error fetching data:', error);
  }
});
</script>

<template>
  <CommodityComponent2 :rows="rows" />
</template>

<style scoped>

</style>