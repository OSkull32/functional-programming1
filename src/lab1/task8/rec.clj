(ns lab1.task8.rec)

; Преобразует строку в список цифр
(defn str-digits [s]
  (map #(Character/digit % 10) s))

; Вычисляет произведение цифр в последовательности
(defn product [digits]
  (reduce * digits))

;Находит максимальное произведение среди всех возможных подряд идущих групп из 13 цифр
(defn find-max-product-rec [nums]
  (loop [parts (partition 13 1 (str-digits nums))
         max-prod 0]
    (if (empty? parts)
      max-prod
      (let [current-prod (product (first parts))]
        (recur (rest parts) (max max-prod current-prod))))))