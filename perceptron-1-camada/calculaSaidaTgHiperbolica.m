function [ y ] = calculaSaidaTgHiperbolica( u )
%UNTITLED11 Summary of this function goes here
%   Detailed explanation goes here

    sigmoid = @(x) (1-exp(-x))/(1+exp(-x));
    y = zeros(1, 3);
    max_valor = max(TgHiperbolica(u));
    for i=1:length(u)
        if (sigmoid(u(i))<max_valor)
            y(i) = -1;
        else
            y(i) = 1;
        end 
    end
    
end

