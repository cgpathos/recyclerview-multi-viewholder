# recyclerview-multi-viewholder

> SDUI 구현하면서 RecyclerView의 ViewHolder를 평소보다 좀더 복잡하게 사용했던 경험을 정리했다.  
> 추가로 서버에서 내려오는 데이터를 RxJava를 이용해서 일정등의 문제로 발생한 제약조건에 맞게 가공했던 경험도 정리했다.

## 조금 더 복잡한 Multi ViewHolder([관련글](https://neopathos.medium.com/%EC%A1%B0%EA%B8%88-%EB%8D%94-%EB%B3%B5%EC%9E%A1%ED%95%9C-multi-viewholder-5575d2906cd7))

### 제약조건

1. 하나의 RecyclerView
1. 기본은 GridLayoutManager
1. 어떤 종류의 컴포넌트가 인접하냐에 따라 사이 간격이 다름



## RxJava를 이용한 서버 데이터 가공

### 제약 조건

1. 각 컴포넌트의 리스트 데이터가 흩어져서 내려 올 수 있음(이걸 각 컴포넌트 별로 합쳐야 함)
    ```
    // 이게 아니고
    [{
       "type":"A"
       "datas":[
          ...
          ]
     },
     ...
    ]

    // 이렇게 내려옴
    [{
       "type":"A"
       "data":{ ... }
     },
     {
       "type":"A"
       "data":{ ... }
     },
     {
       "type":"A"
       "data":{ ... }
     },
     {
       "type":"A"
       "data":{ ... }
     },
     ...
    ]
    ```
1. 일부 컴포넌트는 따로 API 호출을 해서 데이터를 가져와야 함
