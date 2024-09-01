<script setup>
import axiosInstance from '../axios.js'; // axios 설정 파일을 가져옵니다.
import {onMounted, ref} from "vue";

const rows = ref([]);

onMounted(async () => {
  try {
    const response = await axiosInstance.get('/v1/commodity/lowest-price-by-category');
    rows.value = response.data.data.commodities; // API 응답 데이터를 rows에 저장
  } catch (error) {
    console.error('Error fetching data:', error);
  }
})

import {defineProps} from 'vue';

// 부모 컴포넌트에서 전달한 데이터를 받아올 props 정의
const props = defineProps({
  rows: {
    type: Array,
    required: true
  }
});
</script>

<template>
  <div class="flex flex-col">
    <div class="overflow-x-auto sm:-mx-6 lg:-mx-8">
      <div class="inline-block min-w-full py-2 sm:px-6 lg:px-8">
        <div class="overflow-hidden">
          <table class="min-w-full text-left text-sm font-light text-surface dark:text-white">
            <thead class="border-b border-neutral-200 font-medium dark:border-white/10">
            <tr>
              <th scope="col" class="px-6 py-4">#</th>
              <th scope="col" class="px-6 py-4">카테고리명</th>
              <th scope="col" class="px-6 py-4">가격</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="(row, index) in rows" :key="index" class="border-b border-neutral-200 dark:border-white/10">
              <td class="whitespace-nowrap px-6 py-4 font-medium">{{ index + 1 }}</td>
              <template v-if="row.category !== ''">
                <td class="whitespace-nowrap px-6 py-4">{{ row.categoryNm }}</td>
              </template>
              <template v-if="row.price !== ''">
                <td class="whitespace-nowrap px-6 py-4">{{ row.price.toLocaleString('ko-KR') }}</td>
              </template>
            </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</template>
