function [ w ] = aprendizagem( dados, epocas, txAprendizagem, qtdClasses, qtdAtributos, fAtivacao )
%UNTITLED6 Summary of this function goes here
%   Detailed explanation goes here

    dados = horzcat(-ones(size(dados, 1), 1), dados);
    w = rand (qtdClasses, qtdAtributos);

    for i=1:epocas

        dados = dados(randperm(size(dados, 1)), :);
        x = dados(:, 1:size(dados, 2)-qtdClasses);
        d = dados (:,size(x, 2)+1:size(dados,2));

        for j=1:size(x, 2)
            if (fAtivacao == 1)
                u = w*x(j, :)';
                y = calculaSaidaDegrau(u)';
                erro = (d(j, :)-y');
                w = w+(txAprendizagem*erro'*x(j, :));
            elseif (fAtivacao == 2)
                u = w*x(j, :)';
                y = Logistica(u)';
                erro = (d(j, :)-y');
                w = w+(txAprendizagem*(y'*(1-y))*erro'*x(j, :));
            else
                u = w*x(j, :)';
                y = TgHiperbolica(u)';
                erro = (d(j, :)-y');
                w = w+(txAprendizagem*(0.5*(((1+y)'*(1-y))))*erro'*x(j, :));
            end
        end
    end
end

