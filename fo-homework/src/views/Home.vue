<template>
  <div class="p-6 bg-gray-50 min-h-screen">
    <!-- 프로젝트 개요 -->
    <section class="mb-8">
      <h2 class="text-3xl font-extrabold text-gray-800 mb-4">프로젝트 개요</h2>
      <p class="text-gray-700 leading-relaxed">
        이 서비스는 특정 카테고리에서 최저가 브랜드와 상품 가격을 조회하거나, 단일 브랜드로 모든 카테고리 상품을 구매할 때의 최저가를 조회할 수 있는 API를 제공합니다. 또한, 운영자가 브랜드 및 상품을 추가, 업데이트, 삭제할 수 있는 기능을 포함하고 있습니다.
      </p>
    </section>

    <!-- 고객 기능 -->
    <section class="mb-8">
      <h3 class="text-2xl font-semibold text-gray-800 mb-2">고객 기능</h3>
      <ul class="list-disc list-inside text-gray-700 space-y-2">
        <li>카테고리 별로 최저가격인 브랜드와 가격을 조회하고 총액이 얼마인지 확인할 수 있어야 합니다.</li>
      </ul>
    </section>

    <!-- API 엔드포인트 -->
    <section class="mb-8">
      <h4 class="text-xl font-semibold text-gray-800 mb-2">API 엔드포인트</h4>
      <div class="bg-white p-4 rounded-lg shadow-md">
        <ul class="space-y-4">
          <li>
            <strong class="text-blue-600">GET:</strong> <code>/api/v1/categories/lowest-prices</code><br />
            <span class="text-gray-600">설명: 각 카테고리에서 최저 가격의 브랜드와 상품 가격을 조회하고, 그 총액을 반환합니다.</span>
          </li>
          <li>
            <strong class="text-blue-600">GET:</strong> <code>/api/v1/brands/lowest-commodities</code><br />
            <span class="text-gray-600">설명: 단일 브랜드로 모든 카테고리 상품을 구매할 경우 최저가격인 브랜드와 각 상품의 가격, 총액을 반환합니다.</span>
          </li>
          <li>
            <strong class="text-blue-600">GET:</strong> <code>/api/v1/categories/{category}/price-ranges</code><br />
            <span class="text-gray-600">설명: 특정 카테고리에서 최저가격 및 최고가격 브랜드와 해당 상품의 가격을 반환합니다.</span>
          </li>
        </ul>
      </div>
    </section>

    <!-- 운영자 기능 -->
    <section class="mb-8">
      <h3 class="text-2xl font-semibold text-gray-800 mb-2">운영자 기능</h3>
      <ul class="list-disc list-inside text-gray-700 space-y-2">
        <li><strong>브랜드 등록 (POST):</strong> <code>/api/v1/brands</code></li>
        <li><strong>상품 추가 (POST):</strong> <code>/api/v1/commodities</code></li>
        <li><strong>상품 변경 (PUT):</strong> <code>/api/v1/commodities</code></li>
        <li><strong>상품 삭제 (DELETE):</strong> <code>/api/v1/commodities</code></li>
      </ul>
    </section>

    <!-- 기술 스택 -->
    <section class="mb-8">
      <h3 class="text-2xl font-semibold text-gray-800 mb-2">기술 스택</h3>
      <ul class="list-disc list-inside text-gray-700 space-y-2">
        <li><strong>언어:</strong> Java</li>
        <li><strong>프레임워크:</strong> Spring Boot</li>
        <li><strong>데이터베이스:</strong> H2 Database (로컬 인메모리 데이터베이스)</li>
        <li><strong>빌드 도구:</strong> Maven</li>
        <li><strong>테스트:</strong> JUnit, Spring Test</li>
      </ul>
    </section>

    <!-- 테이블 구조 -->
    <section>
      <h3 class="text-2xl font-semibold text-gray-800 mb-2">테이블 구조 (초안)</h3>

      <div class="bg-white p-4 rounded-lg shadow-md mb-4">
        <p class="font-semibold text-gray-800">tbl_brand</p>
        <pre class="bg-gray-50 p-2 rounded-md text-sm text-gray-700 overflow-x-auto">
brand_auto_sn  sort_seq_no  use_yn  brand_nm  reg_id  reg_dtm  modify_id  modify_dtm
1              1            Y       A         System  2022-11-07 16:34:28  System  2022-11-07 16:34:28
2              2            Y       B         System  2022-11-07 16:34:28  System  2022-11-07 16:34:28
3              3            Y       C         System  2022-11-07 16:34:28  System  2022-11-07 16:34:28
4              4            Y       D         System  2022-11-07 16:34:28  System  2022-11-07 16:34:28
        </pre>
      </div>

      <div class="bg-white p-4 rounded-lg shadow-md mb-4">
        <p class="font-semibold text-gray-800">tbl_category</p>
        <pre class="bg-gray-50 p-2 rounded-md text-sm text-gray-700 overflow-x-auto">
category_auto_sn  sort_seq_no  cat_nm  use_yn  reg_id  reg_dtm  modify_id  modify_dtm
00001            1            상의    Y       System  2022-11-07 16:34:28  System  2022-11-07 16:34:28
00002            1            아우터  Y       System  2022-11-07 16:34:28  System  2022-11-07 16:34:28
00003            1            바지    Y       System  2022-11-07 16:34:28  System  2022-11-07 16:34:28
00004            1            스니커즈 Y       System  2022-11-07 16:34:28  System  2022-11-07 16:34:28
00005            1            가방    Y       System  2022-11-07 16:34:28  System  2022-11-07 16:34:28
00006            1            모자    Y       System  2022-11-07 16:34:28  System  2022-11-07 16:34:28
00007            1            양말    Y       System  2022-11-07 16:34:28  System  2022-11-07 16:34:28
00008            1            액세서리 Y       System  2022-11-07 16:34:28  System  2022-11-07 16:34:28
        </pre>
      </div>

      <div class="bg-white p-4 rounded-lg shadow-md">
        <p class="font-semibold text-gray-800">tbl_commodity</p>
        <pre class="bg-gray-50 p-2 rounded-md text-sm text-gray-700 overflow-x-auto">
commodity_no  brand_auto_sn  category_auto_sn  commodity_price  reg_id  reg_dtm  modify_id  modify_dtm
1            1              00001             7000             System  2022-11-07 16:34:28  System  2022-11-07 16:34:28
2            1              00002             3500             System  2022-11-07 16:34:28  System  2022-11-07 16:34:28
3            1              00003             3500             System  2022-11-07 16:34:28  System  2022-11-07 16:34:28
4            1              00003             3500             System  2022-11-07 16:34:28  System  2022-11-07 16:34:28
        </pre>
      </div>
    </section>
  </div>
</template>

<style scoped>
/* 여기에 추가 스타일을 작성할 수 있습니다. */
</style>
