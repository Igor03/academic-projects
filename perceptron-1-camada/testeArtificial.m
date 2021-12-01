clc; clear all; close all;

% O primeiro parametro dessa funcao indica como conjunto de dados deve ser
% gerado: com -1's (para teste da tangente hiperbolica) ou 0's (para as
% outras).
[dados, dClasse1, dClasse2, dClasse3] = gerarDados3Classes(2, 200);
realizacoes = 20;

dClasse1 = dClasse1';
dClasse2 = dClasse2';
dClasse3 = dClasse3';

qtd_classes = 3;
qtd_atributos = 2;

%% TREINAMENTO E TESTE
for k=1:realizacoes
    
    fprintf ('Realizacao %d\n', k);
    
    % CAPTURANDO O CONJUNTO DE TREINAMENTO E O CONJUNTO DE TESTES
    dados = dados(randperm(size(dados, 1)), :);

    conj_treinamento = dados(1:size(dados, 1)-100, :); % 500 amostras para treinamento
    conj_testes = dados (size(dados, 1)-99:end, :); % 100 amostras para testes

    % TREINAMENETO DOS NEURONIOS

    % A funcao retorna uma MATRIZ de pesos
    w = aprendizagem (conj_treinamento, 300, 0.1, 3, 2+1, 3);

    % CALCULANDO ACURACIA

    sem_erro = zeros(1, qtd_classes);
    acertos = 0;

    conj_testes = horzcat(-ones(size(conj_testes, 1), 1), conj_testes);
    x = conj_testes(:, 1:size(conj_testes, 2)-qtd_classes); % Padroes
    d = conj_testes (:,qtd_atributos+2:size(conj_testes,2));  % Saidas desejadas
    
    for i=1:size(conj_testes, 1)
      
        %y = calculaSaidaDegrau(w*x(i,:)');
        %y = calculaSaidaLogistica(w*x(i,:)');
        y = calculaSaidaTgHiperbolica(w*x(i,:)');
        erro = (d(i,:)-y);
        
        if(sem_erro == erro)
            acertos = acertos+1;
        end
    end
    taxa_acertos(k) = acertos/size(conj_testes, 1);
end
%% CALCULANDO ACURACIA E DESVIO PADRAO
disp ('TAXA DE ACERTO POR REALIZACAO')
taxa_acertos'
disp('------------------------------')
fprintf ('ACURACIA %d \f\n', mean(taxa_acertos));
fprintf ('DESVIO PADRAO %d \f\n', std(taxa_acertos));
disp('------------------------------')

%% PLOTANDO DADOS
figure(1)
scatter(dClasse1(:, 1), dClasse1(:, 2), 'red');
hold on;
scatter(dClasse2(:, 1), dClasse2(:, 2), 'green');
hold on;
scatter(dClasse3(:, 1), dClasse3(:, 2), 'blue');
hold on

W_1 = w(1, :);
theta = W_1(1);
w1 = W_1(2);
w2 = W_1(3);
t = 0: .1: 1;
y1 = -(w1/w2)*t + (theta/w2);
plot(t, y1, 'blue');

hold on

W_1 = w(2, :);
theta = W_1(1);
w1 = W_1(2);
w2 = W_1(3);
t = 0: .1: 1;
y1 = -(w1/w2)*t + (theta/w2);
plot(t, y1, 'green');

hold on

W_1 = w(3, :);
theta = W_1(1);
w1 = W_1(2);
w2 = W_1(3);
t = 0: .1: 1;
y1 = -(w1/w2)*t + (theta/w2);
plot(t, y1, 'red');

xlim([0 1])
ylim([0 1])

legend('Classe 1', 'Classe 2', 'Classe 3')
hold off


%% MAPA DE CORES
w1 = w(1,:);
w2 = w(2,:);
w3 = w(3,:);

xrange = [0 1.0];
yrange = [0 1.0];
inc = 0.03;

[x_coord, y_coord] = meshgrid(xrange(1):inc:xrange(2), yrange(1):inc:yrange(2));

xy = [x_coord(:) y_coord(:)];
sizeXY = size(xy);
lines = sizeXY(1);

figure(3)
for i=1:lines
    if((w1(1)*-1+w1(2)*xy(i,1)+w1(3)*xy(i,2)) > 0);
        scatter(xy(i,1),xy(i,2),'*blue');
       hold on; 
    elseif ((w2(1)*-1+w2(2)*xy(i,1)+w2(3)*xy(i,2)) > 0)
        scatter(xy(i,1),xy(i,2),'*green');
       hold on;
    elseif ((w3(1)*-1+w3(2)*xy(i,1)+w3(3)*xy(i,2)) > 0)
        scatter(xy(i,1),xy(i,2),'*red');
       hold on;
    else
       scatter(xy(i,1),xy(i,2),'*red');
       hold on;
    end
end
grid on;
title('Mapa de cores');
%% FIM