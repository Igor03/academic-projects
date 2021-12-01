function [ y ] = TgHiperbolica( u )
%UNTITLED9 Summary of this function goes here
%   Detailed explanation goes here
    
    sigmoid = @(x) (1-exp(-x))/(1+exp(-x));
    y = zeros(1, 3);
    
    for i=1:length(u)
       y(i) = sigmoid(u(i)); 
    end  

end

