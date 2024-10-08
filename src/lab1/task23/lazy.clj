(ns lab1.task23.lazy)

; Возвращает список всех делителей числа n
(defn proper-divisors [n]
  (filter (fn [d] (zero? (mod n d)))
          (range 1 (inc (/ n 2)))))

;  Проверяет, является ли число n избыточным.
(defn abundant? [n]
  (> (reduce + (proper-divisors n)) n))

; Генерирует бесконечную последовательность избыточных чисел.
(defn abundant-numbers []
  (filter abundant? (iterate inc 1)))

(def limit 28123)

; Создает вектор всех избыточных чисел, меньших 28124.
(def abundant-nums (take-while #(< % 28124) (abundant-numbers)))

; Вычисляет все возможные суммы двух избыточных чисел.
(defn sums-of-two-abundant []
  (let [abundant (vec abundant-nums)]
    (for [a abundant
          b abundant]
      (+ a b))))

; Находит все числа, которые не могут быть представлены как сумма двух избыточных чисел.
(defn cannot-be-written-as-sum []
  (let [abundant-sums (into #{} (sums-of-two-abundant))
        all-nums (range 1 limit)]
    (filter #(not (abundant-sums %)) all-nums)))

(defn find-non-abundant-sum-lazy []
  (reduce + (cannot-be-written-as-sum)))

