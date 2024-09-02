<script setup>
import { ref, onMounted } from 'vue';
import axiosInstance from '../axios.js';
import CommodityComponent2 from "../components/CommodityComponent2.vue";
import CommodityComponent from "../components/CommodityComponent.vue";

const rows = ref([]);
const sumPrice = ref();
const brandNm = ref();

onMounted(async () => {
  try {
    const response = await axiosInstance.get('/v1/commodity/lowest-sum-price-by-brand');
    rows.value = response.data.data.commodities;
    sumPrice.value = response.data.data.sumPrice.toLocaleString('ko-KR');
    brandNm.value = response.data.data.brandNm;
  } catch (error) {
    alert('서버에서 오류가 발생했습니다. 잠시 후 다시 시도해 주세요.');
  }
});
</script>

<template>
  <div class="p-6 bg-gray-50 min-h-screen">
    <section class="bg-white p-6 rounded-lg shadow-md mb-8">
      <h2 class="text-xl font-semibold text-gray-800 mb-4">최저가 브랜드 총액</h2>
      <div class="flex items-center justify-between">
        <span class="text-gray-600 text-lg">브랜드</span>
        <span class="font-medium text-gray-900">{{ brandNm }}</span>
      </div>
      <div class="mt-4 flex items-center justify-between">
        <span class="text-gray-600 text-lg">총액</span>
        <span class="font-medium text-green-600 text-xl">{{ sumPrice }} 원</span>
      </div>
    </section>

    <section class="bg-white p-6 rounded-lg shadow-md mb-8">
      <h2 class="text-xl font-semibold text-gray-800 mb-4">상품 리스트</h2>
      <CommodityComponent2 :rows="rows" />
    </section>
  </div>
</template>

<style scoped>

</style>