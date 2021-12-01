function [ y ] = calculaSaidaDegrau( u )
%UNTITLED4 Summary of this function goes here
%   Detailed explanation goes here
    
    y = zeros(1, 3);
    
    for i=1:3
        if (u(i)>0)
            y(i) = 1;
        else
            y(i) = 0;
        end
    end
     
end

