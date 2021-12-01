clc; clear all; close all;

dados = load('iris1.txt');
%dados = load('iris2.txt');
realizacoes = 20;
qtd_classes = 3;
qtd_atributos = 4;

for k=1:realizacoes
    
    fprintf ('Realizacao %d\n', k);
    
    % CAPTURANDO O CONJUNTO DE TREINAMENTO E O CONJUNTO DE TESTES
    dados = dados(randperm(size(dados, 1)), :);

    conj_treinamento = dados(1:size(dados, 1)-30, :); % 500 amostras para treinamento
    conj_testes = dados (size(dados, 1)-29:end, :); % 100 amostras para testes

    % TREINAMENETO DOS NEURONIOS

    % A funcao retorna uma MATRIZ de pesos
    w = aprendizagem (conj_treinamento, 1000, 0.1, qtd_classes, qtd_atributos+1, 2);

    % CALCULANDO ACURACIA

    sem_erro = zeros(1, qtd_classes);
    acertos = 0;

    conj_testes = horzcat(-ones(size(conj_testes, 1), 1), conj_testes);
    x = conj_testes(:, 1:size(conj_testes, 2)-qtd_classes); % Padroes
    d = conj_testes (:,qtd_atributos+2:size(conj_testes,2));  % Saidas desejadas
    
    for i=1:size(conj_testes, 1)
      
        %y = calculaSaidaDegrau(w*x(i,:)');
        y = calculaSaidaLogistica(w*x(i,:)');
        %y = calculaSaidaTgHiperbolica(w*x(i,:)');
        erro = (d(i,:)-y);
        
        if(sem_erro == erro)
            acertos = acertos+1;
        end
    end
    taxa_acertos(k) = acertos/size(conj_testes, 1);
end

disp ('TAXA DE ACERTO POR REALIZACAO')
taxa_acertos'
disp('------------------------------')
fprintf ('ACURACIA %d \f\n', mean(taxa_acertos));
fprintf ('DESVIO PADRAO %d \f\n', std(taxa_acertos));
disp('------------------------------')