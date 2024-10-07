(ns lab1.task23.loop)

;Возвращает собственные делители числа n
(defn divisors [n]

  (loop [i 1
         result []]
    (if (>= i (inc (quot n 2)))
      result
      (if (zero? (mod n i))
        (recur (inc i) (conj result i)) ; добавляем делитель и продолжаем
        (recur (inc i) result))))) ; продолжаем без добавления

;Проверяет, является ли число избыточным
(defn abundant? [n]
  (> (reduce + (divisors n)) n))

(def limit 28123)

;Создает список избыточных чисел до предела
(def abundant-numbers
  (loop [n 12
         result []]
    (if (> n limit)
      result
      (if (abundant? n)
        (recur (inc n) (conj result n)) ; Добавляем n в результат и продолжаем
        (recur (inc n) result))))) ; Продолжаем без добавления

;Находит все суммы двух избыточных чисел до предела.
(def abundant-sums
  (into #{} (for [x abundant-numbers
                  y abundant-numbers
                  :when (<= (+ x y) limit)]
              (+ x y))))

;Находит сумму всех чисел, которые нельзя записать как сумму двух избыточных чисел.
(defn find-non-abundant-sum-loop []
  (reduce + (remove abundant-sums (range 1 (inc limit)))))

